import sys
import json
import traceback
from youtool import YouTube

def get_channel_data(channel_url):
    API_KEYS = ["AIzaSyAvOZXXIu_4LVNVZWxItzGNiU6DivHQHAs"]
    yt = YouTube(API_KEYS, disable_ipv6=True)

    try:
        channel_id = yt.channel_id_from_url(channel_url)
        channel_info = list(yt.channels_infos([channel_id]))[0]

        uploads_playlist_id = "UU" + channel_id[2:]
        playlist_items = list(yt.playlist_videos(uploads_playlist_id))
        video_ids = [v["id"] for v in playlist_items][:5]

        videos_data = []
        for video in yt.videos_infos(video_ids):
            videos_data.append({
                "title": video.get("title"),
                "url": f"https://youtube.com/watch?v={video['id']}",
                "views": video.get("viewCount"),
                "likes": video.get("likeCount"),
                "published_at": video.get("publishedAt")
            })

        return {
            "channel": {
                "name": channel_info.get("title"),
                "id": channel_id,
                "description": channel_info.get("description"),
                "subscribers": channel_info.get("subscriberCount"),
                "views": channel_info.get("viewCount"),
                # "videos": channel_info.get("videoCount"),
                # "url": f"https://youtube.com/channel/{channel_id}"
            },
            "latest_videos": videos_data,
            "quota_used": yt.used_quota
        }

    except Exception as e:
        return {"error": str(e)}

if __name__ == "__main__":
    sys.stdout.reconfigure(encoding='utf-8')

    if len(sys.argv) < 2:
        print("Uso: python get_channel_data.py <URL_DO_CANAL>")
        sys.exit(1)

    data = get_channel_data(sys.argv[1])
    print(json.dumps(data.get("channel", {}), ensure_ascii=False))
