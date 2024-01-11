export default function BFS(graph, start, target) {
    const queue = [start]
    const result = []
    const visited = {}
    visited[start] = true

    let currentVertex

    while(queue.length !== 0) {
        currentVertex = queue.shift()
        result.push(currentVertex)

        if (currentVertex === target) {
            return result
        }
        for (const neighbor in graph.adjacencyList[currentVertex]) {

            if (!visited[neighbor]) {
                visited[neighbor] = true
                queue.push(neighbor)
            }
        }
    }
    return result
}
