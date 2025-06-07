import sys
import json
import traceback
import datetime
from youtool import YouTube

API_KEYS = ["AIzaSyAvOZXXIu_4LVNVZWxItzGNiU6DivHQHAs"]  # Substitua pela(s) sua(s) chave(s)

def get_comments(video_id, max_comments=30):
    yt = YouTube(API_KEYS, disable_ipv6=True)
    comments = []

    try:
        for i, comment in enumerate(yt.video_comments(video_id)):
            if i >= max_comments:
                break
            comments.append({
                "author": comment.get("author") or "",
                "text": comment.get("text") or "",
                "published_at": comment.get("published_at"),
                "likes": comment.get("likes"),
            })

        return {"video_id": video_id, "comments": comments, "quota_used": yt.used_quota}

    except Exception as e:
        return {"error": str(e)}

def datetime_converter(o):
    if isinstance(o, (datetime.datetime, datetime.date)):
        return o.isoformat()
    return str(o)

if __name__ == "__main__":
    sys.stdout.reconfigure(encoding='utf-8')

    if len(sys.argv) < 2:
        print("Uso: python get_video_comments.py <VIDEO_ID>")
        sys.exit(1)

    video_id = sys.argv[1]
    data = get_comments(video_id)
    print(json.dumps(data, ensure_ascii=False, indent=4, default=datetime_converter))
