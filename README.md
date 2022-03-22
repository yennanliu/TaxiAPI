# TaxiService

## 1) File structure
```
├── README.md
├── build.sbt : build file
├── script : test py script
├── src    : main source file


src
├── main
│   └── scala
│       └── com
│           └── yen
│               └── TaxiService
│                   ├── common   : common funcs
│                   ├── controller : service controller handles REST request
│                   ├── dev
│                   ├── model  : data model (case class)
│                   ├── service  : service handles taxi booking logic
│                   └── serviceApp.scala : main service app
└── test
    └── scala
        └── com
            └── yen
                └── TaxiService
                    ├── common : common funcs unit test
                    ├── model : model unit test
                    └── service : service unit test
```

## 2) Run
```bash
#---------------------------
# method 1 : intellJ
#---------------------------
# build, and run via intellJ (via build.sbt)

#---------------------------
# method 2 : sbt
#---------------------------
sbt build
sbt run

#---------------------------
# method 1 : javac command
#---------------------------
# build jar
# run
```
## 3) Run test
```bash
sbt test
```

## 4) API endpoints

#### `POST /api/book`

Your system should pick the nearest available car to the customer location and return the total time taken to travel from the current car location to customer location then to customer destination.

```bash
# example cmd
curl -X POST -H "Content-Type: application/json" \
    -d '{
          "source": {
            "x": 1,
            "y": 1
          },
          "destination": {
            "x": 2,
            "y": 2
          }
        }' \
http://localhost:8888/api/book
```

#### `POST /api/tick`

To facilitate the review of this exercise, your service should expose `/api/tick` REST endpoint, when called should advance your service time stamp by 1 time unit.

#### `PUT /api/reset`

Your service should also provide `/api/reset` REST endpoint, when called will reset all cars data back to the initial state regardless of cars that are currently booked.

Run the test cases in the file [basic_solution_checker.py](basic_solution_checker.py) to check whether your API works correctly


```python
python3 basic_solution_checker.py
```

#### `Other endpoints`

- http://localhost:8080/api/all  : list all cars status
- http://localhost:8080/api/reset : reset all cars status
- http://localhost:9990/admin : service admin UI