import Foundation
import Shared

extension CatListScreen {
    @MainActor 
    class CatListViewModel: ObservableObject {
        private let catRepository = DIHelper().catRepository
        
        @Published var uiState = CatListUiState()
        
        init() {
            getCats()
        }
        
        private func getCats() {
            uiState.isLoading = true
            
            Task {
                for await result in catRepository.getCats() {
                    switch result {
                    case is ApiResultSuccess<NSArray>:
                        let successResult = result as! ApiResultSuccess<NSArray>
                        uiState.isLoading = false
                        uiState.cats = successResult.data as? [Cat] ?? []
                        
                    case is ApiResultError<NSArray>:
                        let errorResult = result as! ApiResultError<NSArray>
                        uiState.isLoading = false
                        uiState.errorMessage = errorResult.message
                        
                    default:
                        break
                    }
                }
            }
        }
    }
}
