# TaxiService


## API endpoints

#### `POST /api/book`

Your system should pick the nearest available car to the customer location and return the total time taken to travel from the current car location to customer location then to customer destination.

#### `POST /api/tick`

To facilitate the review of this exercise, your service should expose `/api/tick` REST endpoint, when called should advance your service time stamp by 1 time unit.

#### `PUT /api/reset`

Your service should also provide `/api/reset` REST endpoint, when called will reset all cars data back to the initial state regardless of cars that are currently booked.

Run the test cases in the file [basic_solution_checker.py](basic_solution_checker.py) to check whether your API works correctly

```python
python3 basic_solution_checker.py
```