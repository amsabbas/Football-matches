//
//  MatchesHeaderWidget.swift
//  ios
//
//  Created by Ahmed Mohamed on 25/01/2023.
//

import Foundation
import SwiftUI
import shared


struct MatchesListWidget: View {
    
    let matches : Matches
  
    init(matches:Matches){
        self.matches = matches
    }
    
    var body: some View {
        List(self.matches.matches,id: \.self) { match in
                HStack(spacing: 25){
                    MatchesTeamWidget(team: match.homeTeam)
                    
                    MatchesTeamWidget(team: match.awayTeam)
                }
                
            }
        .frame(maxWidth: .infinity, maxHeight: .infinity ,alignment:Alignment.center)
    }
}
