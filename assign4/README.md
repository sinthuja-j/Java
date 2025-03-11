Pyramid Chambers with Stacks
Overview
The "Pyramid Chambers with Stacks" program simulates navigating through a pyramid to find the best route to reach treasure chambers. This is done by exploring various chambers and using stack-based data structures to keep track of the path. The program considers various constraints to determine the best possible route for reaching treasures in the pyramid.

How the Game Works
Pyramid Map: A map of chambers within a pyramid is represented in the program. Each chamber has properties such as whether it is lighted, sealed, or contains a treasure.
Pathfinding: The program starts at the entrance of the pyramid and uses a stack-based approach to explore neighboring chambers. It evaluates each chamber's status, looking for treasure chambers.
Conditions: The program checks various conditions to determine the best chamber to explore next:
Treasure: If a chamber contains a treasure, it is prioritized.
Lighted Chambers: If a chamber is lighted and accessible, it is explored.
Dim Chambers: If no better options are available, dimly lit chambers are considered.
Goal: The goal is to find all reachable treasure chambers, navigating through the pyramid efficiently while fulfilling these constraints.

Features
Stack-based Navigation: The program uses a stack to navigate through the pyramid chambers and keep track of the current path.
Chamber States: Chambers can be marked as pushed, popped, lighted, sealed, or containing treasure.
Pathfinding Algorithm: The algorithm explores chambers based on specific conditions to find the best path to all treasures.

How to Use
Run the program with a file containing the pyramid map layout.
The program will display the map and attempt to find the best route from the entrance to the treasure chambers.
The stack will be used to navigate through the pyramid, considering constraints and finding treasures.
This README provides a concise summary of the program’s functionality and how it operates.
