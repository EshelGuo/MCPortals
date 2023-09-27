pluginManagement {
    repositories {
        maven { setUrl("https://maven.aliyun.com/repository/gradle-plugin") }
        maven { setUrl("https://mirrors.cloud.tencent.com/gradle/") }
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        maven { setUrl("https://maven.aliyun.com/repository/gradle-plugin") }
        maven { setUrl("https://mirrors.cloud.tencent.com/gradle/") }
        google()
        mavenCentral()
    }
}

rootProject.name = "地狱门神器"
include(":app")
 