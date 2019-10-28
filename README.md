# mastercloudapp-practica5
Practica 5 - Master clouds Testing

## Draughts
### UML
#### svg
<p align="center">
  <img alt="" src="https://www.plantuml.com/plantuml/svg/lLR1Sjem43r7N-612qbgfkIKGuT9GZojfq2PuDBUEefHYMTiYSfo3DFctojBjYHBeiEfFTNxddPNRz-At9KCKbOLEG1f3iio-0WB50phbuoXDh9ca7MXu3Uuk0umEh3H9GZul-k0eXBfhnrY6vXNY0VUslCF1D9jFsLIKMmL-LL1gWh3vv9HcB90WgiCfLPJZx20_SWArbRE6I5qc-5-zs6GOHOSHBlo_qVUAS9LmVaveGRrONu_-oo8tpx5ITJH8aeLJKQ4GkBQnkbu6IVn_LoSZvS_5bysqI9Q9jttKxJ-keZ4L_GzJdXo8AI_2hUank5KodPX1HlXW1HKnGQtXzj1Ao1eTLIWk9CJ7RmVZoS3gQiBJWIerNCASiBDONBJ9P3ZiKhAu8S_CYhcPSUQYG5X1UkikFDuF9LIj-NrjpIaEgFLxppyI66rUs6bTEi-XqTXnnQTarsMzlpCJJiZc56IvuWAgcL0ZGR38yfpKlE3ql0mJT6UZJHZavKP8xJ9mjs5w4_8x-p0JfxN9ZvQDzkeoPSzSCKlSWfxGcLL81Dzq-jhfdGAYmT0xU-_hjFkMQyB9rr1Nj58U-UTuQFpQonu4hT6jzOGfoW_2TjAE1rIGHWz4v8ZYFbZLZT-EwSve8obp2VC1AIbLB39PySCbngzaR2Zsq71DwDgRQo1UZdz8NafjavUKdyGNeez3j3UlDbNkrMDM0rgm6dBzcz3SgO3B5VwIOurpigbHcY9SOhc2cAz9fiCrS6GK8XtIBbIl1MSOpXFxmEFbTojvn_y7s-AsOtnDdZ2Cf4742-x9ov_adm5cb-GNjopamqE14cRL0i8d85hMeShiQ_2QXzEzNrzO7Tf7wPl3hHc_Pzu0IhXF9WMIJycIXzWIALWfP9HrBUEggfd8usPUTSIt26yvNyt_WK0">
</p>

#### PlantUML
```PlantUML
@startuml

class Game #white
class State #white {
	+ next()
    + reset()
    + getValue()
}
class Board #white
class Turn #white
class Square #white
abstract class Piece #white
class Dama #white
class Pawn #white
class Coordinate #white {
	- int x
    - int y
}
enum Color #white {
	BLACK
    WHITE
}
enum Error #white
enum StateValue #white {
	INITIAL
    IN_MOVEMENT
    IN_RESUME
    EXIT
}

Game *-down-> Board	
Game *-down-> Turn
Board *-down-> "8x8" Square
Square *-down-> Color
Square *-down-> "0..1" Piece
Square *-down-> "1..1" Coordinate
Board *-down-> "1..2x12" Piece
Piece *-down-> Color
Piece <|-down- Dama
Piece <|-down- Pawn
Turn *-down-> Color
Game ..> Error
Board ..> Error
State *-down-> StateValue

class Draughts {
	+ play()
}

class Logic #white {
	+ getController()
}
abstract class Controller #yellow {
    + accept(ControllerVisitor)
}
interface ControllerVisitor #yellow {
    + visit(StartController)
    + visit(PlayController)
    + visit(ResumeController)
}
class StartController #yellow {
    + start()
    + accept(ControllerVisitor)
}
class PlayController #yellow {
    + move(Coordinate, Coordinate)
    + accept(ControllerVisitor)
}
class MoveController #yellow
class CancelController #yellow
class ResumeController #yellow {
    + resume(boolean newGame)
    + accept(ControllerVisitor)
}

Draughts *-down-> Logic
Logic *-down-> Game
Logic *-down-> StateValue
Controller o--> Game
Controller o--> State
Controller <|-down- StartController
Controller <|-down- PlayController
Controller <|-down- ResumeController
Controller <|-down- MoveController
Controller <|-down- CancelController

Logic ..> StartController
Logic ..> PlayController
Logic ..> ResumeController
StartController ..> ControllerVisitor
PlayController ..> ControllerVisitor
ResumeController ..> ControllerVisitor
PlayController *-down-> MoveController
PlayController *-down-> CancelController

abstract class View #orange {
    + interact(Controller)
}
class ConsoleView #orange {
    + interact(Controller)
    + visit(StartController)
    + visit(PlayController)
    + visit(ResumeController)
}
class StartView #orange
class PlayView #orange
class ResumeView #orange
class BoardView #orange
class SquareView #orange
class PieceView #orange

Draughts *-down-> View
View <|-down- ConsoleView
ControllerVisitor <|-down- View
ConsoleView *-up-> StartView
ConsoleView *-up-> PlayView
ConsoleView *-up-> ResumeView
StartView *-down-> BoardView
PlayView *-down-> BoardView
BoardView *-down-> SquareView
SquareView *-down-> PieceView
StartView ..> StartController
PlayView ..> PlayController
ResumeView ..> ResumeController

@enduml
```
