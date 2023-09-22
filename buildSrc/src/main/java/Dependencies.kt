//Unified Dependency Version
object Config {
    const val canaryApplicationId = "com.cisco.wx2.android.test.canary"
    const val ciApplicationId = "com.cisco.wx2.android.ci"
    const val prodApplicationId = "com.cisco.wx2.android"
    const val defaultAutomotiveId = "com.cisco.wx2.android.automotive"
    const val ciAutomotiveId = "com.cisco.wx2.android.automotive.ci"
    const val canaryAutomotiveId = "com.cisco.wx2.android.automotive.canary"
    const val fordDevAutomotiveId = "com.oem.ford.webexdev"
    const val fordProdAutomotiveId = "com.oem.ford.webex"
    const val msintuneApplicationId = "com.cisco.wx2.android.msintune"
    const val intuneCanaryApplicationId = "com.cisco.wx2.android.canary.intune"
    const val experimentalApplicationId = "com.cisco.wx2.android.test.exp"
    const val testInstrumentationRunner = "com.webex.teams.testshared.testrunner.TeamsTestRunner"
}

object Modules {
    // when you make changes to this items in this block
    // please update settings.gradle.kts file too
    // you will find the reason for this in that file
    const val app = ":app"
    const val platformAndroid = ":platform-android"
    const val platformAndroidWrapper = ":platform-android-wrapper"
    const val core = ":core"
    const val detektCustomRules = ":detekt-custom-rules"
    const val videoCompressor = ":videocompressor"
    const val colorPalette = ":color-palette"
    const val automotive = ":automotive"
    const val aaosUIToolkit = ":aaos-ui-toolkit"
    const val intentjourneytest = ":intentjourneyapp"
    const val appShared = ":app-shared"
    const val testShared = ":test-shared"
    const val instrumentationTestLib = ":instrumentation-test-lib"
    const val unitTestLib = ":unit-test-lib"
    const val authentication = ":authentication"
    const val meetingsCalendar = ":meetings-calendar"
    const val meetingsWeekView = ":meetings-week-view"
    const val uiToolkit = ":ui-toolkit"
    const val codegen = ":codegen"
}

object Versions {
    const val ndkVersion = "24.0.8215888"
    const val compileSdk = 33
    const val minSdk = 26
    const val targetSdk = 33
    const val automotive_minSdk = 29

    // https://blog.jetbrains.com/kotlin/category/releases/
    const val kotlin = "1.8.10"
    const val kotlinCoroutines = "1.6.4"
    const val koin = "3.3.3"
    const val playCore = "1.10.3"
    const val ktx = "1.9.0"
    const val androidxFragment = "1.5.7"
    const val activityKtx = "1.7.0"
    const val navigation = "2.5.3"
    const val testCore = "1.5.0"
    const val lifecycle = "2.5.1"

    // https://mvnrepository.com/artifact/androidx.test.espresso/espresso-core
    const val espresso = "3.2.0"
    const val junit = "4.13.2"
    const val xmlRunListener = "0.4.0"
    const val mockito = "4.11.0"
    const val mockitoKotlin = "4.1.0"
    const val mockitoInline = "5.2.0"
    const val robolectric = "4.10"
    const val playPublisherVersion = "1.2.2"
    const val constraintLayoutX = "2.1.4"
    const val ktlint = "0.48.2"
    const val spotless = "6.18.0"
    const val gradleVersionsPlugin = "0.20.0"
    const val glide = "4.15.1"
    const val firebaseBoM = "31.4.0"
    const val mlKitSmartReply = "17.0.2"

    // https://firebase.google.com/support/release-notes/android#latest_sdk_versions
    const val googleServicesGradlePlugin = "4.3.15"
    const val crashlyticsGradle = "2.9.2"
    const val preference = "1.2.0"
    const val dataStore = "1.0.0"
    const val orhanobutLogger = "2.2.0"
    const val paging = "3.1.1"

    // https://square.github.io/leakcanary/changelog/
    const val leakCanary = "2.10"

    // https://github.com/cashapp/turbine/releases
    const val turbine = "0.12.1"

    // https://github.com/facebook/shimmer-android/releases
    const val shimmer = "0.5.0"
    const val exifinterface = "1.3.6"
    const val uiAutomator = "2.2.0"
    const val testRunnerVersion = "1.0.2"
    const val appCompat = "1.6.1"
    const val libwhiteboarding = "git-908f045239"
    const val jsoup = "1.15.4"
    const val gson = "2.10.1"
    const val dottedProgressBar = "1.0.0"

    // https://mvnrepository.com/artifact/com.google.android.material/material
    const val material = "1.9.0"
    const val adaptiveCardVersion = "2.8.4"
    const val pinView = "3.1.0"
    const val protobufJavaLite = "3.20.1"
    const val rightSheetBehavior = "1.0"
    const val lottieVersion = "6.0.0"
    const val viewPager2 = "1.0.0"
    const val browser = "1.5.0"
    const val cameraX = "1.2.1"
    const val media = "1.6.0"
    const val javassist = "3.28.0-GA"
    const val exoplayer = "2.12.0"
    const val guavaAndroid = "31.1-android"
    const val webkitX = "1.6.0"
    const val okHttp = "4.10.0"
    const val googleAccountLogin = "19.0.0"
    const val mimeTypes = "1.0.4"
    const val palette = "1.0.0"
    const val composeVersion = "1.4.3"
    const val composeNavigation = "2.5.3"
    const val composeConstraintLayout = "1.0.1"
    const val composePager = "0.18.0"
    const val composePagerIndicator = "0.18.0"
    const val composeMaterial3 = "1.1.0"
    const val securityCrypto = "1.1.0-alpha03"
    const val securityCredential = "1.0.0-alpha02"
    const val securityAuthenticator = "1.0.0-alpha02"
    const val securityAuthenticatorTest = "1.0.0-alpha01"
    const val subsamplePhotoView = "3.10.0"
    const val flexBoxLayout = "3.0.0"
    const val workManager = "2.8.1"
    const val extTestingVersion = "1.1.5"
    const val detekt = "1.22.0"
    const val carsApp = "1.2.0"
    const val experimentalVersion = "1.4.0-SNAPSHOT"
    const val zxing = "4.3.0"
    const val gradleTestLogger = "3.2.0"
    const val glanceAppWidget = "1.0.0-alpha05"
    const val arCore = "1.35.0"
    const val filamentAndroid = "1.14.0"
    const val filamentUtils = "1.14.0"
    const val filamentGltf = "1.14.0"
}

object CameraX {
    const val cameraCore = "androidx.camera:camera-core:${Versions.cameraX}"
    const val cameraVideo = "androidx.camera:camera-video:${Versions.cameraX}"
    const val camera2 = "androidx.camera:camera-camera2:${Versions.cameraX}"
    const val cameraLifeCycle = "androidx.camera:camera-lifecycle:${Versions.cameraX}"
    const val cameraView = "androidx.camera:camera-view:${Versions.cameraX}"
}

object Firebase {
    // BoM is used to make sure all Firebase lib versions are compatible
    // https://firebase.google.com/docs/android/learn-more#bom

    const val bom = "com.google.firebase:firebase-bom:${Versions.firebaseBoM}"
    const val cloudMessaging = "com.google.firebase:firebase-messaging-ktx"
    const val analytics = "com.google.firebase:firebase-analytics-ktx"
}

object MLKit {
    // Reference: https://developers.google.com/ml-kit/language/smart-reply/android
    const val mlKitSmartReply = "com.google.mlkit:smart-reply:${Versions.mlKitSmartReply}"
}

object LeakCanary {
    const val leakCanary = "com.squareup.leakcanary:leakcanary-android:${Versions.leakCanary}"
}

object Crashlytics {
    // When using BoM, versions numbers come from there
    const val ndk = "com.google.firebase:firebase-crashlytics-ndk"
}

object Kotlin {
    const val stdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}"
    const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.kotlinCoroutines}"
    const val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.kotlinCoroutines}"
}

object Log {
    const val orhanobutLogger = "com.orhanobut:logger:${Versions.orhanobutLogger}"
}

object ArchComponents {
    const val activityKtx = "androidx.activity:activity-ktx:${Versions.activityKtx}"
    const val androidxFragment = "androidx.fragment:fragment-ktx:${Versions.androidxFragment}"
    const val coreKtx = "androidx.core:core-ktx:${Versions.ktx}"
    const val navFragmentKtx = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    const val navUiKtx = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
    const val liveDataKtx = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"
    const val viewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    const val processKtx = "androidx.lifecycle:lifecycle-process:${Versions.lifecycle}"
    const val protoBufJava = "com.google.protobuf:protobuf-javalite:${Versions.protobufJavaLite}"
    const val serviceKtx = "androidx.lifecycle:lifecycle-service:${Versions.lifecycle}"
    const val lifecycleCompiler = "androidx.lifecycle:lifecycle-compiler:${Versions.lifecycle}"
    const val coreTesting = "androidx.arch.core:core-testing:2.1.0"
    const val biometric = "androidx.biometric:biometric-ktx:1.2.0-alpha03"
    const val extTesting = "androidx.test.ext:junit-ktx:${Versions.extTestingVersion}"
    const val testOrchestrator = "androidx.test:orchestrator:1.1.1"
    const val preference = "androidx.preference:preference-ktx:${Versions.preference}"
    const val dataStore = "androidx.datastore:datastore-preferences:${Versions.dataStore}"
    const val uiAutomator = "androidx.test.uiautomator:uiautomator:${Versions.uiAutomator}"
    const val navTesting = "androidx.navigation:navigation-testing:${Versions.navigation}"
    const val testCore = "androidx.test:core-ktx:${Versions.testCore}"
    const val workManager = "androidx.work:work-runtime-ktx:${Versions.workManager}"
}

object Compose {
    const val composeRuntime = "androidx.compose.runtime:runtime:${Versions.composeVersion}"
    const val composeUi = "androidx.compose.ui:ui:${Versions.composeVersion}"
    const val composeFoundation = "androidx.compose.foundation:foundation:${Versions.composeVersion}"
    const val composeFoundationLayout = "androidx.compose.foundation:foundation-layout:${Versions.composeVersion}"
    const val composeMaterial = "androidx.compose.material:material:${Versions.composeVersion}"
    const val composeRuntimeLiveData = "androidx.compose.runtime:runtime-livedata:${Versions.composeVersion}"
    const val composeUiTooling = "androidx.compose.ui:ui-tooling:${Versions.composeVersion}"
    const val composeThemeAdapter = "com.google.android.material:compose-theme-adapter:${Versions.composeVersion}"
    const val composeUiTestJunit4 = "androidx.compose.ui:ui-test-junit4:${Versions.composeVersion}"
    const val composeUiTestManifest = "androidx.compose.ui:ui-test-manifest:${Versions.composeVersion}"
    const val composeUiTest = "androidx.compose.ui:ui-test:${Versions.composeVersion}"
    const val composeNavigation = "androidx.navigation:navigation-compose:${Versions.composeNavigation}"
    const val composeConstraintlayout = "androidx.constraintlayout:constraintlayout-compose:${Versions.composeConstraintLayout}"
    const val composePager = "com.google.accompanist:accompanist-pager:${Versions.composePager}"
    const val composePageIndicator = "com.google.accompanist:accompanist-pager-indicators:${Versions.composePagerIndicator}"
    const val composeFlowLayout = "com.google.accompanist:accompanist-flowlayout:${Versions.composePager}"
    const val composeMaterial3 = "androidx.compose.material3:material3:${Versions.composeMaterial3}"
}

object Glance {
    const val glanceAppWidget = "androidx.glance:glance-appwidget:${Versions.glanceAppWidget}"
}

object AndroidXSecurity {
    const val securityCrypto = "androidx.security:security-crypto:${Versions.securityCrypto}"
    const val securityIdentityCredential = "androidx.security:security-identity-credential:${Versions.securityCredential}"
    const val securityAppAuthenticator = "androidx.security:security-app-authenticator:${Versions.securityAuthenticator}"
    const val securityAppAuthenticatorTest = "androidx.security:security-app-authenticator:${Versions.securityAuthenticatorTest}"
}

object AndroidXCars {
    const val carsApp = "androidx.car.app:app:${Versions.carsApp}"
    const val carsAppProjected = "androidx.car.app:app-projected:${Versions.carsApp}"
    const val carsAppAutomotive = "androidx.car.app:app-automotive:${Versions.carsApp}"

    const val carsAppExperimental = "androidx.car.app:app:${Versions.experimentalVersion}"
    const val carsAppProjectedExperimental = "androidx.car.app:app-projected:${Versions.experimentalVersion}"
    const val carsAppAutomotiveExperimental = "androidx.car.app:app-automotive:${Versions.experimentalVersion}"
}

object Koin {
    const val core = "io.insert-koin:koin-core:${Versions.koin}"
    const val test = "io.insert-koin:koin-test:${Versions.koin}"
    const val android = "io.insert-koin:koin-android:${Versions.koin}"
    const val testJUnit = "io.insert-koin:koin-test-junit4:${Versions.koin}"
}

object Play {
    const val core = "com.google.android.play:core:${Versions.playCore}"
    const val installreferrer = "com.android.installreferrer:installreferrer:2.2"
}

object Deps {
    const val constraintLayoutX = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayoutX}"
    const val junit = "junit:junit:${Versions.junit}"
    const val xmlRunListener = "de.schroepf:android-xml-run-listener:${Versions.xmlRunListener}"
    const val testRunner = "com.android.support.test:runner:${Versions.testRunnerVersion}"

    const val robolectric = "org.robolectric:robolectric:${Versions.robolectric}"

    const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    const val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.glide}"
    const val jsoup = "org.jsoup:jsoup:${Versions.jsoup}"
    const val adaptiveCards = "io.adaptivecards:adaptivecards-android:${Versions.adaptiveCardVersion}"
}

object Espresso {
    const val intents = "androidx.test.espresso:espresso-intents:${Versions.espresso}"
    const val contrib = "androidx.test.espresso:espresso-contrib:${Versions.espresso}"
    const val core = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    const val web = "androidx.test.espresso:espresso-web:${Versions.espresso}"
    const val idlingResource = "androidx.test.espresso:espresso-idling-resource:${Versions.espresso}"
}

object Mockito {
    const val core = "org.mockito:mockito-core:${Versions.mockito}"
    const val android = "org.mockito:mockito-android:${Versions.mockito}"
    const val kotlin = "org.mockito.kotlin:mockito-kotlin:${Versions.mockitoKotlin}"
    const val inline = "org.mockito:mockito-inline:${Versions.mockitoInline}"
}

object Isseiaoki {
    const val simplecropview = "com.isseiaoki:simplecropview:1.1.8"
}

object Testing {
    const val fragmentTesting = "androidx.fragment:fragment-testing:${Versions.androidxFragment}"
    const val workTesting = "androidx.work:work-testing:${Versions.workManager}"
    const val coroutineTesting = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.kotlinCoroutines}"
    const val turbine = "app.cash.turbine:turbine:${Versions.turbine}"
}

object Paging {
    const val paging = "androidx.paging:paging-runtime-ktx:${Versions.paging}"
}

object Shimmer {
    const val shimmer = "com.facebook.shimmer:shimmer:${Versions.shimmer}"
}

object Exifinterface {
    const val exifInterface = "androidx.exifinterface:exifinterface:${Versions.exifinterface}"
}

object AppCompat {
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
}

object Whiteboarding {
    const val libwhiteboarding = "com.cisco.newb:libwhiteboarding_jni:${Versions.libwhiteboarding}"
}

object Gson {
    const val gson = "com.google.code.gson:gson:${Versions.gson}"
}

object DottedProgressBar {
    const val dottedProgressBar = "com.github.igortrncic.dotted-progress-bar:library:${Versions.dottedProgressBar}"
}

object Material {
    const val material = "com.google.android.material:material:${Versions.material}"
}

object PinView {
    const val pinView = "com.github.mukeshsolanki.android-otpview-pinview:otpview:${Versions.pinView}"
}

object RightSheetBehavior {
    const val rightSheetBehavior = "com.github.OKatrych:RightSheetBehavior:${Versions.rightSheetBehavior}"
}

object Lottie {
    const val lottie = "com.airbnb.android:lottie:${Versions.lottieVersion}"
}

object ViewPager2 {
    const val viewPager2 = "androidx.viewpager2:viewpager2:${Versions.viewPager2}"
}

object ChromeCustomTabs {
    const val browser = "androidx.browser:browser:${Versions.browser}"
}

object MediaNotificationCompat {
    const val media = "androidx.media:media:${Versions.media}"
}

object Exoplayer {
    const val exoplayer_core = "com.google.android.exoplayer:exoplayer-core:${Versions.exoplayer}"
    const val exoplayer_ui = "com.google.android.exoplayer:exoplayer-ui:${Versions.exoplayer}"
    const val exoplayer_hls = "com.google.android.exoplayer:exoplayer-hls:${Versions.exoplayer}"
}

object GuavaAndroid {
    const val guavaAndroid = "com.google.guava:guava:${Versions.guavaAndroid}"
}

object FlexBoxLayout {
    const val flexBoxLayout = "com.google.android.flexbox:flexbox:${Versions.flexBoxLayout}"
}

object WebkitX {
    const val webkit = "androidx.webkit:webkit:${Versions.webkitX}"
}

object OkHttp {
    const val okHttp = "com.squareup.okhttp3:okhttp:${Versions.okHttp}"
    const val okHttpTls = "com.squareup.okhttp3:okhttp-tls:${Versions.okHttp}"
    const val mockWebServer = "com.squareup.okhttp3:mockwebserver:${Versions.okHttp}"
}

object PlayService {
    const val googleAccountLogin = "com.google.android.gms:play-services-auth:${Versions.googleAccountLogin}"
}

object MimeTypes {
    const val mimeTypes = "org.overviewproject:mime-types:${Versions.mimeTypes}"
}

object Palette {
    const val paletteKtx = "androidx.palette:palette-ktx:${Versions.palette}"
}

object SubsamplePhotoView {
    const val subsamplePhotoView = "com.davemorrissey.labs:subsampling-scale-image-view-androidx:${Versions.subsamplePhotoView}"
}

object GradleArgs {
    val kotlinFreeCompilerArgList = listOf("-opt-in=kotlin.RequiresOptIn")
    const val teamsCompileSdk = "teamsCompileSdk"
}

object StaticAnalysis {
    const val detekt = "io.gitlab.arturbosch.detekt"
    const val detektAPI = "io.gitlab.arturbosch.detekt:detekt-api:${Versions.detekt}"
    const val detektCLI = "io.gitlab.arturbosch.detekt:detekt-cli:${Versions.detekt}"
    const val detektTest = "io.gitlab.arturbosch.detekt:detekt-test:${Versions.detekt}"
    const val detektFormatting = "io.gitlab.arturbosch.detekt:detekt-formatting:${Versions.detekt}"
    const val detektGradlePlugin = "io.gitlab.arturbosch.detekt:detekt-gradle-plugin:${Versions.detekt}"

    const val spotless = "com.diffplug.spotless"
    const val spotlessGradlePlugin = "com.diffplug.spotless:spotless-plugin-gradle:${Versions.spotless}"
}

object Zxing {
    const val zxing = "com.journeyapps:zxing-android-embedded:${Versions.zxing}"
}

object GradleLogger {
    const val testLoggerPlugin = "com.adarshr:gradle-test-logger-plugin:${Versions.gradleTestLogger}"
}

object Share3DObject {
    const val arcore_api = "com.google.ar:core:${Versions.arCore}"
}

object Filament {
    const val filamentAndroid = "com.google.android.filament:filament-android:${Versions.filamentAndroid}"
    const val filamentUtils = "com.google.android.filament:filament-utils-android:${Versions.filamentUtils}"
    const val filamentGltf = "com.google.android.filament:gltfio-android:${Versions.filamentGltf}"
}
