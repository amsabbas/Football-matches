//
//  ContentView.swift
//  ios
//
//  Created by Ahmed Mohamed on 23/01/2023.
import shared

import SwiftUI

struct NavigationWidget: View {
    var body: some View {
        TabView {
            MatchesScreen()
                .tabItem {
                    Image(systemName: "figure.australian.football")
                    Text("Matches")
                }.padding(.all,8)
            TeamsScreen()
                .tabItem {
                    Image(systemName: "soccerball")
                    Text("Teams")
                }.padding(.all,8)
        }
        
    }
    
    init() {
        UITabBar.appearance().barTintColor = UIColor.systemBlue
        UITabBar.appearance().unselectedItemTintColor = UIColor.gray
        UITabBar.appearance().isTranslucent = false

    }
}

struct NavigationWidget_Previews: PreviewProvider {
    static var previews: some View {
        NavigationWidget()
    }
}
