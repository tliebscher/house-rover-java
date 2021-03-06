# house-rover-java
An exercise in Java modeled after the Thoughtworks mars rover coding exercise
and based on https://github.com/priyaaank/MarsRover

### House Rover puzzle
--------------------

A robotic rover is deployed in a house. The house is assumed to be flat and
consists of rectangular rooms connected by doors.
The rooms must be navigated by the rover.

A rover's position and location is represented by
* a string representing the name of a room,
* a combination of x and y co-ordinates and
* a letter representing one of the four cardinal compass points.

Rooms are divided up into a grid to simplify navigation.
An example position might be A 0,0 N, which means the rover is in room A in
the bottom left corner and facing North.

Assume that the lower-left corner of a room is 0,0, while the upper right corner is denoted by a pair of positive integers.
Assume further that the x and y dimensions of a room are greater then 0.

Assume that the square directly North from (x, y) is (x, y+1).

In order to control a rover, users send a simple string of letters.
The possible letters are 'L','R','T' and 'M'.
'L'eft and 'R'ight makes the rover spin 90 degrees left or right respectively,
without moving from its current spot.
'T'urn makes the rover turn 180 degrees, without moving from its current spot.
'M' means move forward one grid point, and maintain the same heading.

Doors connect rooms. Doors are represented by
* a string representing the name of the door and
* 2 sets of information for entering and leaving a room, each represented by
    * a room
    * a combination of x and y co-ordinates of the door and
* a letter representing one of the four cardinal compass points as the direction of the door.

Stairs connect rooms too. Stairs are one-demensional and are represented by
* a string representing the name of the door and
* 2 sets of information for entering and leaving a room, each represented by
    * a room
    * a combination of x and y co-ordinates of the door and
* a letter representing one of the four cardinal compass points as the direction of the door.
* a number of stairs
Assume stairs can be entered on one side but left on both sides (the rover can turn).

### LICENSE

Full License Text
The MIT License (MIT)

Copyright (c) 2014 Priyank Gupta
Copyright (c) 2014 Thomas Liebscher

Permission is hereby granted, free of charge, to any person obtaining a
copy of this software and associated documentation files (the
"Software"), to deal in the Software without restriction, including
without limitation the rights to use, copy, modify, merge, publish,
distribute, sublicense, and/or sell copies of the Software, and to
permit persons to whom the Software is furnished to do so, subject to
the following conditions:

The above copyright notice and this permission notice shall be included
in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS
OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY
CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT,
TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE
SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.