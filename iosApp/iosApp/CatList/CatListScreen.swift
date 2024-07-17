import SwiftUI
import Shared

struct CatListScreen: View {
    
    private(set) var navigateToCatDetail: (String) -> Void
    
    @StateObject private var viewModel = CatListViewModel()
    
    init(navigateToCatDetail: @escaping (String) -> Void) {
        self.navigateToCatDetail = navigateToCatDetail
    }
    
    var body: some View {
        ZStack {
            if viewModel.uiState.isLoading {
                ProgressView()
                    .frame(maxWidth: .infinity, maxHeight: .infinity, alignment: .center)
                    .zIndex(1)
            }
            
            List(viewModel.uiState.cats, id: \.self) { cat in
                CatItem(
                    cat: cat,
                    onClick: { navigateToCatDetail(cat.id) }
                )
            }
        }
        .navigationTitle("Find Your Cats")
    }
}
