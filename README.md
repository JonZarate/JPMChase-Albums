# Albums exercise

A very simple app that downloads and displays a list of albums. Titles are ordered alphabetically and all is stored locally. 

![](/images/main.png)

## Architecture

This sample was built using Model-View-ViewModel (MVVM) along with Data Binding & LiveData. It uses Coroutines to handle background work and a combination of manual Dependency Injection & Repository Pattern in order to keep components independent and testable.

## Dependencies


* [Retrofit](https://github.com/square/retrofit)
* [Room](https://developer.android.com/training/data-storage/room)
* [LiveData](https://developer.android.com/topic/libraries/architecture/livedata)
* [Coroutines](https://developer.android.com/kotlin/coroutines)
* [Robolectric](http://robolectric.org)
* [Mockito](https://github.com/mockito/mockito)
* [MockK](https://github.com/mockk/mockk)

## Future improvements

This is just a small showcase, but if we were to maintain it long term, there's lots of things that could be done!

* Mock the web responses on the tests
* Gradually load albums with [Paging](https://developer.android.com/topic/libraries/architecture/paging)
* On a larger project, might be worth using a Dependency Injection library - like [Dagger 2](https://github.com/google/dagger)