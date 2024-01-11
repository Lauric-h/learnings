export default function DFSIterative(graph, start, target) {
    const stack = [start]
    const visited = {}
    const result = []

    visited[start] = true
    let currentVertex

    while(stack.length !== 0) {
        currentVertex = stack.pop()
        result.push(currentVertex)

        if (currentVertex === target) {
            return result
        }
        for (const neighbor in graph.adjacencyList[currentVertex]) {
            if (!visited[neighbor]) {
                visited[neighbor] = true
                stack.push(neighbor)
            }
        }
    }
    return undefined
}
