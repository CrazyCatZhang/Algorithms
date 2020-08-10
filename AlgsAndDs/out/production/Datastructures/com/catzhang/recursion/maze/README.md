# Maze

## 1. Problem Description

 - ##### Use recursion to easily realize the maze path finding problem

## 2. Achieve

 - ##### `map` represents the maze map

   ```java
   int[][] map
   ```

   

 - ##### `i` and `j` indicate which position on the map to start from

   ```java
   int i, int j
   ```

   

 - ##### If the ball can reach the position of `map[6][5]`, then the path has found

   ```java
   if (maze[6][5] == 2) {
       return true;
   }
   ```

   

 - ##### Convention: When `map[i][j]` is `0`, it means the point has not been walked. When it is `1`, it means the wall;`2` means that the path can be walked; `3` means the point has been walked, but can’t go through

 - ##### When walking through the maze, you need to determine a strategy, such as `down->right->up->left`, if the point can’t go through, go back

```java
else {
    if (maze[i][j] == 0) {
        maze[i][j] = 2;
        if (getWay(maze, i + 1, j)) {
            return true;
        } else if (getWay(maze, i, j + 1)) {
            return true;
        } else if (getWay(maze, i - 1, j)) {
            return true;
        } else if (getWay(maze, i, j - 1)) {
            return true;
        } else {
            maze[i][j] = 3;
            return false;
        }
    } else {
        return false;
    }
}
```



