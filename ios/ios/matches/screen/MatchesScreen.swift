//
//  MatchesScreen.swift
//  ios
//
//  Created by Ahmed Mohamed on 24/01/2023.
//

import Foundation


import SwiftUI
import shared

struct MatchesScreen: View {
    
    @ObservedObject var viewModel: MatchesViewModel
    
    init() {
        self.viewModel = MatchesViewModel()
        self.viewModel.getMatches()
    }
    
    var body: some View {
       
        switch self.viewModel.matchesResource {
                case .idle:
                    ProgressView()
                case Resource.loading:
                    ProgressView()
                case Resource.error(let error):
                    Text(error.getErrorMessage())
                case Resource.success(let matches):
                        
                    VStack(alignment: HorizontalAlignment.leading){
                        
                        MatchesHeaderWidget(imageURL: matches.competition?.emblem ?? "", season: (matches.filters?.season ?? ""))
                        
                        MatchesTabsWidget(viewModel: self.viewModel)
                        
                        MatchesListWidget(matches: matches)
                        
                    }.frame(maxWidth: .infinity,maxHeight: .infinity,alignment: .top)
        }
    }
}

