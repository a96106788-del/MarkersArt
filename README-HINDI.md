# Markers Art — Android starter project

**App:** Markers Art  
**Platform:** Android only  
**UI language:** Hindi + English  
**Initial export target:** 1080p workflow (Media3 export currently uses the source's video dimensions; explicit 1080p scaling is not yet configured).

## इस शुरुआती वर्जन में
- Native Android Kotlin app
- Video picker (Android document picker)
- Video preview using ExoPlayer
- Start/end time based trimming
- MP4 export using AndroidX Media3 Transformer
- GitHub Actions workflow to build a debug APK

## मोबाइल से APK बनाने के चरण
1. इस ZIP को फोन में Extract करें।
2. GitHub पर नया public या private repository `MarkersArt` बनाएँ।
3. Extract किए गए प्रोजेक्ट की सभी फाइलें और `.github` hidden folder सहित upload करें।
4. GitHub repository में **Actions** खोलें।
5. यदि पहली बार हो, तो **I understand my workflows, go ahead and enable them** चुनें।
6. **Build Markers Art APK** workflow खोलें और **Run workflow** दबाएँ।
7. Build सफल होने पर workflow run के नीचे **Artifacts** में `Markers-Art-debug-APK` डाउनलोड करें।
8. ZIP को Extract करें। `app-debug.apk` Android फोन में install करें।

## Local build
- JDK 17
- Android SDK Platform 35
- Gradle 8.9+ (CI uses Gradle wrapperless setup via installed Gradle)
- Android Studio: open this folder and run `assembleDebug`.

## Important limitations
यह एक वास्तविक शुरुआती Android app है, लेकिन अभी पूर्ण CapCut विकल्प नहीं है।
- Trim export implemented; audio/music mixing, split editing, multi-track timeline, text overlays, filters, transitions, templates, project save/restore and true 1080p scaling are not yet implemented.
- Export is written to the app-specific Movies folder. Android app-specific storage may not be directly visible in every Files app.
- This project is a source ZIP, not an APK. GitHub Actions builds the APK after you upload it.
- First build may take several minutes and requires internet access.
