//
//  MatchesTeamWidget.swift
//  ios
//
//  Created by Ahmed Mohamed on 25/01/2023.
//

import Foundation

import Foundation
import SwiftUI
import shared


struct MatchesTeamWidget: View {
    
    private var team : Team?
  
    init(team:Team?){
        self.team = team
    }
    
    var body: some View {
       
        HStack(spacing: 10){
            
            AsyncImage(url: URL(string: self.team?.crest ?? "")) { image in
                image
                    .resizable()
                    .scaledToFill()
            } placeholder: {
                ProgressView()
            }
            .frame(width: 20, height: 20)
            
            
            Text(team?.name ?? "")
            
        }.frame(width: 120)
    }
}
