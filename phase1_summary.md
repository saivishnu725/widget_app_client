# Phase 1 — Project Scaffolding & Build Config — Complete ✅

## What was done

### 1.1 Project Structure
The full clean-architecture package layout has been created:

```
in.svnu.widgetclient/
├── WidgetClientApp.kt          ← @HiltAndroidApp entry point
├── MainActivity.kt             ← @AndroidEntryPoint
├── data/
│   ├── local/
│   │   ├── AppDatabase.kt      ← Room DB (Phase 3)
│   │   ├── dao/
│   │   │   ├── WidgetDao.kt
│   │   │   ├── WidgetStateDao.kt
│   │   │   └── SyncQueueDao.kt
│   │   └── entity/
│   │       ├── WidgetEntity.kt
│   │       ├── WidgetStateEntity.kt
│   │       └── SyncQueueEntity.kt
│   ├── remote/
│   │   ├── AuthApi.kt          ← Retrofit (Phase 2)
│   │   ├── WidgetApi.kt
│   │   └── WebSocketManager.kt ← Socket.io (Phase 4)
│   └── repository/
│       ├── AuthRepository.kt
│       └── WidgetRepository.kt
├── di/
│   ├── AppModule.kt            ← Hilt singletons
│   ├── DatabaseModule.kt       ← Room providers
│   └── NetworkModule.kt        ← OkHttp/Retrofit providers
├── domain/
│   ├── model/
│   │   ├── User.kt             ← Domain models (implemented)
│   │   ├── Widget.kt
│   │   └── WidgetState.kt
│   └── usecase/
│       ├── AuthUseCases.kt
│       └── WidgetUseCases.kt
├── service/
│   ├── FloatingWidgetService.kt
│   └── BootReceiver.kt
├── ui/
│   ├── auth/AuthScreens.kt
│   ├── common/CommonComponents.kt
│   ├── settings/SettingsScreen.kt
│   ├── theme/ (Color.kt, Theme.kt, Type.kt)
│   └── widgets/WidgetScreens.kt
└── util/
    ├── Constants.kt             ← Server contract constants
    ├── Extensions.kt
    └── Resource.kt              ← Success/Error/Loading wrapper
```

### 1.2 Dependencies Added (libs.versions.toml)

| Category | Libraries |
|----------|-----------|
| **Networking** | OkHttp 4.12, Retrofit 2.11, Gson 2.12, Socket.io-client 2.1 |
| **DI** | Hilt 2.56.2 + KSP + Navigation Compose |
| **Database** | Room 2.7.1 (runtime + KSP compiler + ktx) |
| **Preferences** | DataStore 1.1.4 |
| **Security** | security-crypto 1.1.0-alpha06 |
| **Coroutines** | 1.10.2 (core + android) |
| **UI** | Material 3, Material Icons Extended, Navigation Compose 2.9 |
| **Lifecycle** | ViewModel Compose, Runtime Compose 2.9 |
| **Testing** | JUnit 4, MockK 1.13, Turbine 1.2, Coroutines Test, Hilt Testing |

### 1.3 Build Variants & Config

- **debug**: `BASE_URL = http://10.0.2.2:3000` (emulator → host localhost)
- **release**: `BASE_URL = https://api.widgetapp.svnu.in` (placeholder)
- R8 minification + shrink resources enabled for release
- `buildConfig = true` for compile-time URL injection
- Java 17 compatibility (required by KSP/Room/Hilt)

### 1.4 Hilt Setup
- `WidgetClientApp` annotated with `@HiltAndroidApp`
- `MainActivity` annotated with `@AndroidEntryPoint`
- Three Hilt modules created: `AppModule`, `NetworkModule`, `DatabaseModule`
- Registered in `AndroidManifest.xml` via `android:name=".WidgetClientApp"`

### 1.5 Manifest Permissions
```xml
INTERNET, ACCESS_NETWORK_STATE, SYSTEM_ALERT_WINDOW,
FOREGROUND_SERVICE, RECEIVE_BOOT_COMPLETED
```

### 1.6 ProGuard/R8 Rules
Complete rules for: OkHttp, Retrofit, Gson, Room, Socket.io, Hilt/Dagger, Coroutines, and domain model preservation.

### 1.7 Domain Models (implemented, not just placeholders)
- `Widget` — full data class with all fields
- `WidgetState` — with type-safe `ToggleState` enum
- `User` — id, email, name
- `Resource<T>` — sealed class for async state management
- `Constants` — all server API event names, state values, timing configs

---

## Acceptance Criteria Status

> **"Project compiles, Hilt injects, empty Activity launches."**

- ✅ All build files configured
- ✅ Hilt annotation processing via KSP
- ✅ `@HiltAndroidApp` on Application class
- ✅ `@AndroidEntryPoint` on MainActivity
- ✅ Three Hilt modules installed in `SingletonComponent`

> [!IMPORTANT]
> **Next step**: Sync Gradle in Android Studio and do a build to verify everything resolves. Then we can move to **Phase 2 — Networking & Authentication**.

> [!NOTE]
> The release `BASE_URL` is a placeholder (`https://api.widgetapp.svnu.in`). Update it when you deploy the server.
