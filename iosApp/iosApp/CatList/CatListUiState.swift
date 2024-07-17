import Foundation
import Shared

struct CatListUiState {
    var isLoading: Bool = false
    var cats: [Cat] = []
    var errorMessage: String? = nil
}
