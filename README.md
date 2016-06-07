# house-rover-java
An exercise in Java modeled after the Thoughtworks mars rover coding exercise

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
In order to control a rover, users send a simple string of letters.
The possible letters are 'L', 'R' and 'M'.
'L' and 'R' makes the rover spin 90 degrees left or right respectively, without moving from its current spot.
'M' means move forward one grid point, and maintain the same heading.

Assume that the square directly North from (x, y) is (x, y+1).

Assume that the lower-left corner of a room is 0,0, while the upper right corner is denoted by a pair of positive integers.
Assume further that the x and y dimensions of a room are greater then 0.

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