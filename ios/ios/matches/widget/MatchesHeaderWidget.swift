//
//  MatchesHeaderWidget.swift
//  ios
//
//  Created by Ahmed Mohamed on 25/01/2023.
//

import Foundation
import SwiftUI


struct MatchesHeaderWidget: View {
    
    private var imageURL : String
    private var season : String
    
    init(imageURL:String, season: String){
        self.imageURL = imageURL
        self.season = season
    }
    
    var body: some View {
        HStack(spacing: 25){
            
            AsyncImage(url: URL(string: imageURL)) { image in
                image
                    .resizable()
                    .scaledToFill()
            } placeholder: {
                ProgressView()
            }
            .frame(width: 90, height: 90)
            
            
            Text("Season " + season)
            
        }.frame(maxWidth: .infinity)
    }
}
