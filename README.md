
# Yazio Android – No Backend (CI Ready)

Questa app Android usa **API non ufficiali di Yazio** direttamente dall'app (OAuth password grant + endpoints dati). Gli endpoint possono cambiare: verifica la documentazione community prima del rilascio.

## Configurazione rapida
1. Carica questo repo su GitHub.
2. Vai su **Settings → Secrets and variables → Actions → New repository secret** e crea:
   - `YAZIO_CLIENT_ID`
   - `YAZIO_CLIENT_SECRET`
   - (per release) `KEYSTORE_BASE64`, `KEY_ALIAS`, `KEYSTORE_PASSWORD`, `KEY_PASSWORD`
3. Vai nella tab **Actions** e lancia **Android Debug APK** (artifact = APK), oppure **Android Release AAB** (artifact = AAB firmato).

## Dove inserire i parametri?
I valori sono letti da variabili d'ambiente in build time (`BuildConfig.YAZIO_*`). Se non presenti, usano i placeholder nel `build.gradle`.

## Attenzione sicurezza
Inserire client id/secret nell'app non è sicuro (possono essere estratti dall'APK). Valuta un **backend proxy** se pubblichi su store.

## Riferimenti community (API non ufficiali Yazio)
- Descrizione API + OAuth: repository community `saganos/yazio_public_api`.
