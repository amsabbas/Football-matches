//
//  ios
//
//  Created by Ahmed Mohamed on 25/01/2023.
//

import Foundation

import Foundation
import SwiftUI
import shared


struct MatchesTabsWidget: View {
    
    @ObservedObject var viewModel: MatchesViewModel
    
    init(viewModel: MatchesViewModel){
        self.viewModel = viewModel
    }
    
    
    var body: some View {
       
        ScrollView (.horizontal, showsIndicators: false) {
             HStack {
                 ForEach(0 ..< self.viewModel.matchesDays,id: \.self) { i in
                     if (i == self.viewModel.weekdaySelectedTabIndex){
                         Text("Week \(i+1)".convertedDigitsToLocale(Locale(identifier: "EN")))
                             .padding(.horizontal,8).foregroundColor(.black)
                             .onTapGesture {
                                 self.viewModel.weekdaySelectedTabIndex = i
                                 self.viewModel.getMatches()
                             }
                     }
                     else{
                         Text("Week \(i+1)".convertedDigitsToLocale(Locale(identifier: "EN")))
                             .padding(.horizontal,8).foregroundColor(.gray)
                             .onTapGesture {
                                 self.viewModel.weekdaySelectedTabIndex = i
                                 self.viewModel.getMatches()
                              }
                     }
                 }
             }
        }.frame(height: 70)
        

    }
}


