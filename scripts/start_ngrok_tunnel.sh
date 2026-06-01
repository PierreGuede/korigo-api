#!/usr/bin/env bash

set -euo pipefail

if [[ -n "${NGROK_BIN:-}" ]]; then
  SELECTED_NGROK_BIN="$NGROK_BIN"
elif [[ -x "/tmp/ngrok-bin/ngrok" ]]; then
  SELECTED_NGROK_BIN="/tmp/ngrok-bin/ngrok"
else
  SELECTED_NGROK_BIN="ngrok"
fi

PORT="${PORT:-8080}"
NGROK_URL="${NGROK_URL:-}"
NGROK_DOMAIN="${NGROK_DOMAIN:-}"

if [[ ! -x "$SELECTED_NGROK_BIN" ]] && ! command -v "$SELECTED_NGROK_BIN" >/dev/null 2>&1; then
  echo "ngrok est introuvable. Installe le binaire ou exporte NGROK_BIN=/chemin/vers/ngrok." >&2
  exit 1
fi

if [[ -z "$NGROK_URL" && -n "$NGROK_DOMAIN" ]]; then
  NGROK_URL="https://$NGROK_DOMAIN"
fi

if [[ -n "$NGROK_URL" ]]; then
  exec "$SELECTED_NGROK_BIN" http "$PORT" --url "$NGROK_URL" --inspect=false
fi

exec "$SELECTED_NGROK_BIN" http "$PORT" --inspect=false
