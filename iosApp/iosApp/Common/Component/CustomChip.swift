import SwiftUI

struct CustomChip: View {
    let icon: String
    let text: String
    
    var body: some View {
        HStack {
            Image(systemName: icon)
                .font(.footnote)
                .foregroundColor(.white)
            Text(text)
                .font(.footnote)
                .fontWeight(.semibold)
                .foregroundColor(.white)
        }
        .padding(5)
        .background(.brown)
        .clipShape(RoundedRectangle(cornerRadius: 5))
    }
}
