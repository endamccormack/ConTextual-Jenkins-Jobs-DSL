buildMonitorView('ConTextual') {
    description('All jobs for ConTextual')
    jobs {
        name('ContextualFrontend')
        name('ContextualAPI')
        name('ContextualDatabase')
    }
}
