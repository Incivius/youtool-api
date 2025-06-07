import sys
import json
from pathlib import Path
from youtool import YouTube

def get_transcription(video_id, lang="pt"):
    API_KEYS = ["AIzaSyAvOZXXIu_4LVNVZWxItzGNiU6DivHQHAs"]
    yt = YouTube(API_KEYS, disable_ipv6=True)
    output_dir = Path("transcriptions")
    output_dir.mkdir(parents=True, exist_ok=True)

    try:
        result = list(yt.download_transcriptions([video_id], language_code=lang, path=output_dir))

        if result and result[0].get("status") == "done" and result[0].get("filename"):
            text = Path(result[0]["filename"]).read_text(encoding="utf-8")
            return {
                "video_id": video_id,
                "transcription": text,
                "quota_used": yt.used_quota,
                "status": "success"
            }
        else:
            return {
                "video_id": video_id,
                "status": result[0].get("status") if result else "no_result",
                "quota_used": yt.used_quota
            }

    except Exception as e:
        return {
            "video_id": video_id,
            "status": "error",
            "message": str(e)
        }

if __name__ == "__main__":
    if len(sys.argv) < 2:
        print(json.dumps({
            "status": "error",
            "message": "Uso: python get_transcription.py <VIDEO_ID> [LANGUAGE]"
        }, ensure_ascii=False), file=sys.stderr)
        sys.exit(1)

    video_id = sys.argv[1]
    lang = sys.argv[2] if len(sys.argv) > 2 else "pt"
    data = get_transcription(video_id, lang)
    print(json.dumps(data, ensure_ascii=False))
