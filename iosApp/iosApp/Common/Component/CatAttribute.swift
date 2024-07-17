import SwiftUI
import Shared

struct CatAttribute: View {
    let key: String
    let value: CatAttributeType
    
    var body: some View {
        HStack {
            Text(key)
                .font(.system(size: 16))
                .fontWeight(.semibold)
                .frame(maxWidth: .infinity, alignment: .leading)
            
            ZStack {
                switch value {
                case is CatAttributeTypeText:
                    let attribute = value as! CatAttributeTypeText
                    
                    Text(attribute.text)
                        .font(.system(size: 16))
                    
                case is CatAttributeTypeRating:
                    let attribute = value as! CatAttributeTypeRating
                    
                    BulletRating(rating: attribute.rating)
                    
                default:
                    EmptyView()
                }
            }
            .frame(maxWidth: .infinity, alignment: .leading)
        }
    }
}
