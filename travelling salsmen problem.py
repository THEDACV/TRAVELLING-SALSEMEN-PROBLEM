from sys import maxsize
from itertools import permutations

def tsp(graph, start):
    
    vertices = [i for i in range(len(graph)) if i != start]
    
   
    min_cost = maxsize
    
   
    for perm in permutations(vertices):
        current_cost = 0
        k = start
        
        
        for j in perm:
            current_cost += graph[k][j]
            k = j
        current_cost += graph[k][start]  
        
       
        min_cost = min(min_cost, current_cost)
    
    return min_cost

#example usage
graph = [
    [0, 10, 15, 20],
    [10, 0, 35, 25],
    [15, 35, 0, 30],
    [20, 25, 30, 0]
]

start_vertex = 0
print("Minimum cost:", tsp(graph, start_vertex))