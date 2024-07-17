import Foundation

import Shared

extension CatDetailScreen {
    @MainActor
    class CatDetailViewModel: ObservableObject {
        private let catRepository = DIHelper().catRepository
        
        @Published var uiState = CatDetailUiState()
        
        func getCatDetail(id: String) {
            uiState.isLoading = true
            
            Task {
                for await result in catRepository.getCatDetail(id: id) {
                    switch result {
                    case is ApiResultSuccess<Cat>:
                        let successResult = result as! ApiResultSuccess<Cat>
                        uiState.isLoading = false
                        uiState.cat = successResult.data
                        
                    case is ApiResultError<Cat>:
                        let errorResult = result as! ApiResultError<Cat>
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
