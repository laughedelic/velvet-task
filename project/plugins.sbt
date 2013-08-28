resolvers ++= Seq(
  "Era7 maven releases" at "http://releases.era7.com.s3.amazonaws.com"
// , Resolver.url("Era7 ivy releases", url("http://releases.era7.com.s3.amazonaws.com"))(Resolver.ivyStylePatterns)
// , Resolver.url("Era7 ivy snapshots", url("http://snapshots.era7.com.s3.amazonaws.com"))(Resolver.ivyStylePatterns)
// Team 3
, Resolver.url("Team 3 ivy releases", url("http://releases.team-3.com.s3.amazonaws.com"))(Resolver.ivyStylePatterns)
, Resolver.url("Team 3 ivy snapshots", url("http://snapshots.team-3.com.s3.amazonaws.com"))(Resolver.ivyStylePatterns)
)

addSbtPlugin( "team-3" % "sbt-statika-team-3" % "0.1.0" )
