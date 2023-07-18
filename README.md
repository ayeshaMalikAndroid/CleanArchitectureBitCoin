# CleanArchitectureBitCoin
SOLID is an acronym for five design principles in Object-Oriented software development intended to make software designs more understandable, flexible and maintainable. These five principles are described by Robert C. Martin. SOLID principles are briefly as follows:

S — Single Responsibility Principle (known as SRP)
O — Open/Closed Principle
L — Liskov’s Substitution Principle
I — Interface Segregation Principle
D — Dependency Inversion Principle
Clean Architecture 
UI/Presentation -> Domain Layer(usercase) -> Data Layer(repository)

Presenation: UI layer.
Domain:Business layer.
Data:Repository layer

Presentation layer:Displaying data the user like activity,fragment,view,adapter,viewmodel.
Data:implementation repository detail of repository.
The data layer of an app contains the business logic. The business logic is what gives value to your app—it's made of rules that determine how your app creates, stores, and changes data.

The data layer is made of repositories that each can contain zero to many data sources. You should create a repository class for each different type of data you handle in your app.
Presentation only allow to communicate with domain it cann't communicated with data layer.Example:Room database,remote data source,retrofit,model.
The role of the UI layer (or presentation layer) is to display the application data on the screen. Whenever the data changes, either due to user interaction (such as pressing a button) or external input (such as a network response), the UI should update to reflect the changes.
Separation of concern:major changes migrating one api to another its only going effect data layer.
The UI layer is made up of two things:

UI elements that render the data on the screen. You build these elements using Views or Jetpack Compose functions.
State holders (such as ViewModel classes) that hold data, expose it to the UI, and handle logic.


Domain Layer:Business logic(set of rule,actions,make app valuable).
Business logic is different to UI Logic.
UI logic how to display things on screens.
Business logic what to do with events and data changes.
Domain layer is made up of usecase.
Use Case:
represent single task which the user can or do which the app performs on the user's behalf.
Simple
Light weight
Immutable.
UC depend upon lower layer(data layer)
Domain layer shouldn't depended on higher layer like UI layer .
Use case contain resuable logic so they can also be use for other usecase.
Use cases they don't have their lifecycle instead they're scoped to the class that uses them.
Usecases donot contain mutable data so you can safely create a new instance of a usecase class everytime of a usecase class every time pass it as a depending.

Mapper: used to map the network model to a UI model which will occur in Use Case layer.
