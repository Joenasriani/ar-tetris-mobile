# Google Play release checklist

Rockin' Tetris is configured as a paid, offline-first Android game with no ads, no in-app purchases, and no network permissions.

## Build requirements

Use Java 17 with the Android Gradle Plugin in this project:

```bash
JAVA_HOME=/root/.local/share/mise/installs/java/17.0.2 gradle :app:bundleRelease
```

The Play upload artifact is produced at:

```text
app/build/outputs/bundle/release/app-release.aab
```

## Release signing

Google Play requires a signed Android App Bundle. Provide the release keystore values through Gradle properties when building locally or in CI:

```properties
ARTETRIS_RELEASE_STORE_FILE=/absolute/path/to/release.keystore
ARTETRIS_RELEASE_STORE_PASSWORD=your-store-password
ARTETRIS_RELEASE_KEY_ALIAS=your-key-alias
ARTETRIS_RELEASE_KEY_PASSWORD=your-key-password
```

Versioning can be overridden per release without editing source files:

```properties
ARTETRIS_VERSION_CODE=2
ARTETRIS_VERSION_NAME=1.0.1
```

Do not commit keystores, passwords, or generated signing files to source control.

## Play Console declarations

Use these declarations as a starting point and verify them in the Play Console before submission:

- App access: no restricted access.
- Ads: no ads.
- In-app purchases: none; monetization is intended as an upfront paid download.
- Data safety: the app stores best score locally with Android DataStore and does not request network access.
- Permissions: no dangerous permissions are declared.
- Target audience/content: puzzle game; confirm the final questionnaire answers with the product owner.

## Human validation required

Before upload, a release owner must validate:

1. The final app title, short description, full description, screenshots, feature graphic, and privacy policy URL in the Play Console.
2. The production signing key is generated, backed up, and stored securely.
3. The Play Console content rating and target audience questionnaires match the final store listing.
4. The generated `.aab` is tested on representative phones before production rollout.
