import Graph  from "./DataStructure/Graph.js";
import BFS from "./Algorithms/BFS.js";
import DFSIterative from "./Algorithms/DFSIterative.js";
import DFSRecursive from "./Algorithms/DFSRecursive.js";
import Dijkstra from "./Algorithms/Dijkstra.js";
import AStar from "./Algorithms/AStar.js";

const graph = new Graph()
const numberOfVertices = 12

/**
 * Build tree-like graph
 */
// graph.addEdge({vertex: 'A', cost: 1}, {vertex: 'B', cost: 1})
// graph.addEdge({vertex: 'A', cost: 5}, {vertex: 'E', cost: 5})
// graph.addEdge({vertex: 'A', cost: 2}, {vertex: 'I', cost: 2})
// graph.addEdge({vertex: 'B', cost: 3}, {vertex: 'C', cost: 3})
// // graph.addEdge({vertex: 'C', cost: 9}, {vertex: 'D', cost: 9})
// graph.addEdge({vertex: 'D', cost: 1}, {vertex: 'L', cost: 1})
// graph.addEdge({vertex: 'E', cost: 6}, {vertex: 'F', cost: 6})
// graph.addEdge({vertex: 'E', cost: 7}, {vertex: 'H', cost: 7})
// graph.addEdge({vertex: 'F', cost: 1}, {vertex: 'H', cost: 1})
// graph.addEdge({vertex: 'F', cost: 1}, {vertex: 'G', cost: 1})
// // graph.addEdge({vertex: 'G', cost: 2}, {vertex: 'L', cost: 2})
// graph.addEdge({vertex: 'H', cost: 1}, {vertex: 'K', cost: 1})
// graph.addEdge({vertex: 'I', cost: 150}, {vertex: 'J', cost: 150})
// // graph.addEdge({vertex: 'J', cost: 2}, {vertex: 'K', cost: 2})
// // graph.addEdge({vertex: 'K', cost: 5}, {vertex: 'L', cost: 5})
// // graph.addEdge({vertex: 'D', cost: 2}, {vertex: 'M', cost: 2})

/**
 * Build grid-like graph
 */
graph.addEdge({vertex: 'A', cost: 1}, {vertex: 'B', cost: 1})
graph.addEdge({vertex: 'A', cost: 1}, {vertex: 'D', cost: 1})
graph.addEdge({vertex: 'B', cost: 1}, {vertex: 'C', cost: 1})
graph.addEdge({vertex: 'B', cost: 1}, {vertex: 'E', cost: 1})
graph.addEdge({vertex: 'C', cost: 1}, {vertex: 'F', cost: 1})
graph.addEdge({vertex: 'D', cost: 1}, {vertex: 'E', cost: 1})
graph.addEdge({vertex: 'D', cost: 1}, {vertex: 'G', cost: 1})
graph.addEdge({vertex: 'E', cost: 1}, {vertex: 'F', cost: 1})
graph.addEdge({vertex: 'E', cost: 1}, {vertex: 'H', cost: 1})
graph.addEdge({vertex: 'F', cost: 1}, {vertex: 'I', cost: 1})
graph.addEdge({vertex: 'G', cost: 1}, {vertex: 'H', cost: 1})
graph.addEdge({vertex: 'H', cost: 1}, {vertex: 'I', cost: 1})

console.log(graph)

// console.log(BFS(graph, 'A', 'H'))
// console.log(DFSIterative(graph, 'A', 'H'))
// console.log(DFSRecursive(graph, 'A', 'H'))
// console.log(Dijkstra(graph, 'A', 'H'))
console.log(AStar(graph, 'A', 'H'))

