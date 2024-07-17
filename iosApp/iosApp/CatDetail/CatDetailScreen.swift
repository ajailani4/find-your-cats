import SwiftUI
import NukeUI
import Shared

struct CatDetailScreen: View {
    
    private(set) var id: String
    
    @StateObject private var viewModel = CatDetailViewModel()

    init(id: String) {
        self.id = id
    }
    
    var body: some View {
        ZStack {
            if viewModel.uiState.isLoading {
                ProgressView()
                    .frame(maxWidth: .infinity, maxHeight: .infinity, alignment: .center)
                    .zIndex(1)
            }
            
            if let cat = viewModel.uiState.cat {
                ScrollView {
                    VStack(alignment: .leading) {
                        VStack(alignment: .center) {
                            LazyImage(url: URL(string: cat.imageLink)) { state in
                                if let image = state.image {
                                    image.resizable().aspectRatio(contentMode: .fill)
                                } else if state.isLoading {
                                    ProgressView()
                                }
                            }
                            .frame(width: 250, height: 250)
                            .clipShape(RoundedRectangle(cornerRadius: 20))
                            .padding(.bottom, 12)
                            
                            Text(cat.name)
                                .font(/*@START_MENU_TOKEN@*/.title/*@END_MENU_TOKEN@*/)
                        }
                        .frame(maxWidth: .infinity)
                        .padding(.bottom, 30)
                        
                        VStack(spacing: 15) {
                            CatAttribute(key: "Origin", value: CatAttributeTypeText(text: cat.origin))
                            CatAttribute(key: "Length", value: CatAttributeTypeText(text: cat.length))
                            CatAttribute(key: "Family Friendly", value: CatAttributeTypeRating(rating: cat.familyFriendlyRating))
                            CatAttribute(key: "General Health", value: CatAttributeTypeRating(rating: cat.generalHealthRating))
                            CatAttribute(key: "Grooming", value: CatAttributeTypeRating(rating: cat.groomingRating))
                        }
                    }
                    .padding(20)
                }
            }
        }
        .onAppear {
            viewModel.getCatDetail(id: self.id)
        }
        .navigationTitle("Detail")
    }
}
