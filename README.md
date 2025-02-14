<sub>(*does this count as inverse kinematics??*)</sub>

for those curious:  
this works by using math (transformations).  
basically, the coordinates of each point are stored in an array, meaning i can have any number of points i want just by changing the size of the array  
then i use logic to get the coordinates of a point and the point in front of it, and subtract one from the other to get their positions relative to each other (thats a translation)  
next, i use the distance formula to find the distance between the points
then i create a ratio to scale the points by (thats a dilation).  
this ratio is equal to diameter/distance so that if the points are within a diameter of each other, they will be scaled away from each other since the denominator will be smaller than 20, and vice versa, this can be changed so the points are as close or as far as you want  
once the points are scaled correctly, i add back in the origional translation to get the actual positions of the points.
i iterate through every set of points and readjust them. the front point just follows the mouse.
