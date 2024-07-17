import SwiftUI
import Shared

struct ContentView: View {
    @State private var path = NavigationPath()
    
    var body: some View {
        NavigationStack(path: $path) {
            CatListScreen(navigateToCatDetail: { id in
                path.append("\(ScreenRoute.catDetail.rawValue)/\(id)")
            })
            .navigationDestination(for: String.self) { path in
                let extractedRoute = path.split(separator: "/")
                
                if extractedRoute[0] == ScreenRoute.catDetail.rawValue {
                    CatDetailScreen(id: String(extractedRoute[1]))
                }
            }
        }
    }
}
