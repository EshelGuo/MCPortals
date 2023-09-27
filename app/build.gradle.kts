@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.kotlinAndroid)
}

android {
    namespace = "cn.mc.portals"
    compileSdk = 33

    defaultConfig {
        applicationId = "cn.mc.portals"
        minSdk = 21
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        buildConfig = true
    }
    viewBinding {
        enable = true
    }
//    composeOptions {
//        kotlinCompilerExtensionVersion = "1.4.3"
//    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    //kotlin核心库和android组件kotlin兼容库
    implementationKtx()
    //单元测试框架
    implementationTest()
    //本地moudle依赖
    implementationMoudles()
    //UI相关库
    implementationUI()
    //数据处理相关库
//    implementationData()
}


fun DependencyHandlerScope.implementationUI() {
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.baserecyclerviewadapter)
//    implementationNavigation()
//    implementationPaging()
    implementation(libs.fragment.ktx)
    implementation (libs.shapeview)
}

fun DependencyHandlerScope.implementationData() {
//    implementation(libs.eventbus)
    //Jetpack系列数据库组件: Room
//    implementationRoom()
}

fun DependencyHandlerScope.implementationMoudles() {
//    implementation(project(mapOf("path" to ":base")))
}

fun DependencyHandlerScope.implementationPaging(){

//    implementation(libs.paging.runtime)

    // alternatively - without Android dependencies for tests
//    testImplementation("androidx.paging:paging-common:$paging_version")

    // optional - RxJava2 support
//    implementation("androidx.paging:paging-rxjava2:$paging_version")

    // optional - RxJava3 support
//    implementation("androidx.paging:paging-rxjava3:$paging_version")

    // optional - Guava ListenableFuture support
//    implementation("androidx.paging:paging-guava:$paging_version")

    // optional - Jetpack Compose integration
//    implementation("androidx.paging:paging-compose:1.0.0-alpha18")
}

fun DependencyHandlerScope.implementationNavigation() {
    // Kotlin
//    implementation(libs.navigation.ui)
//    implementation(libs.navigation.fragment)

    // Java language implementation
//    implementation("androidx.navigation:navigation-fragment:$nav_version")
//    implementation("androidx.navigation:navigation-ui:$nav_version")


    // Feature module Support
//    implementation("androidx.navigation:navigation-dynamic-features-fragment:$nav_version")

    // Testing Navigation
//    androidTestImplementation("androidx.navigation:navigation-testing:$nav_version")

    // Jetpack Compose Integration
//    implementation("androidx.navigation:navigation-compose:$nav_version")
}

fun DependencyHandlerScope.implementationRoom() {
//    implementation(libs.room.runtime)
//    annotationProcessor(libs.room.compiler)
    // To use Kotlin Symbol Processing (KSP)
//    ksp(libs.room.compiler)
    // optional - Kotlin Extensions and Coroutines support for Room
//    implementation(libs.room.ktx)
    // To use Kotlin annotation processing tool (kapt)
//    kapt("androidx.room:room-compiler:$room_version")
//    // optional - Guava support for Room, including Optional and ListenableFuture
//    implementation("androidx.room:room-guava:$room_version")
//    // optional - Test helpers
//    testImplementation("androidx.room:room-testing:$room_version")
//    // optional - Paging 3 Integration
//    implementation("androidx.room:room-paging:$room_version")
}

fun DependencyHandlerScope.implementationKtx() {
    implementation(libs.core.ktx)
    implementation(libs.lifecycle.runtime.ktx)
    implementation(libs.lifecycle.viewmodel.ktx)
}

/*fun DependencyHandlerScope.implementationComposeLibs() {
    implementation(libs.activity.compose)
    implementation(platform(libs.compose.bom))
    implementation(libs.ui)
    implementation(libs.ui.graphics)
    implementation(libs.ui.tooling.preview)
    implementation(libs.material3)
    debugImplementation(libs.ui.tooling)
    debugImplementation(libs.ui.test.manifest)
    androidTestImplementation(platform(libs.compose.bom))
//    androidTestImplementation(libs.ui.test.junit4)
}*/

fun DependencyHandlerScope.implementationTest() {
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)
}