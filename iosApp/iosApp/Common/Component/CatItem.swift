import SwiftUI
import NukeUI
import Shared

struct CatItem: View {
    let cat: Cat
    let onClick: () -> Void
    
    var body: some View {
        Button(action: { onClick() }) {
            HStack {
                LazyImage(url: URL(string: cat.imageLink)) { state in
                    if let image = state.image {
                        image.resizable().aspectRatio(contentMode: .fill)
                    } else if state.isLoading {
                        ProgressView()
                    }
                }
                .frame(width: 110, height: 110)
                .clipShape(RoundedRectangle(cornerRadius: 10))
                .padding(.trailing, 10)
                
                VStack(alignment: .leading) {
                    Text(cat.name)
                        .font(.system(size: 22))
                        .foregroundColor(.black)
                        .padding(.bottom, 12)
                    CustomChip(icon: "leaf.fill", text: cat.origin)
                    CustomChip(icon: "ruler.fill", text: cat.length)
                }
            }
        }
    }
}
