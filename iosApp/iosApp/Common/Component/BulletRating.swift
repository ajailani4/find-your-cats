import SwiftUI

struct BulletRating: View {
    let rating: Int32
    
    var body: some View {
        HStack {
            ForEach(0..<5) { i in
                Circle()
                    .frame(width: 10, height: 10)
                    .foregroundColor(i <= rating - 1 ? .blue : .gray)
            }
        }
    }
}
