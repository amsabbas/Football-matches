//
//  ContentView.swift
//  ios
//
//  Created by Ahmed Mohamed on 23/01/2023.
//

import SwiftUI

struct ContentView: View {
    var body: some View {
        TabView {
            Text("Matches")
                .tabItem {
                    Image(systemName: "figure.australian.football")
                    Text("Matches")
                }
            Text("Teams")
                .tabItem {
                    Image(systemName: "soccerball")
                    Text("Teams")
                }
        }
        
    }
    
    
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
