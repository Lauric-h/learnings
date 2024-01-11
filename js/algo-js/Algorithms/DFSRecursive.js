export default function DFSRecursive(graph, vertex, target, visited = new Set()) {
    if(!visited.has(vertex)) {
        visited.add(vertex)
        if (vertex === target) {
            return vertex
        }
        for(const neighbor in graph.adjacencyList[vertex]) {
            let path = DFSRecursive(graph, neighbor, target, visited)
            if(path) {
                return visited
            }
        }
    }
    return undefined
}
