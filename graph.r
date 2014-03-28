#
# run with r CMD BATCH graph.r
#
# Disclaimer: This works on my Mac. I'm not an R expert, so no guarantees...
#
# This command file uses a manually preformatted version of JMH's human-readable output (see benchmark-result.csv)

library("ggplot2")
data <- read.csv("benchmark-result.csv", header=TRUE)

# basic setup
gg <- ggplot(data, aes(x=Approach,fill=Operation,weight=Throughput))+geom_bar(position="dodge")
# set appearance/labels
gg <- gg + ylab("Mean Throughput [op/µs]")+scale_fill_hue(l=30)

ggsave(file="false_sharing_microbenchmark.svg", plot=gg, width=10, height=6)

# see http://mcfromnz.wordpress.com/2013/09/03/ggplot-powerpoint-wall-head-solution/
options(bitmapType="cairo")
ggsave("false_sharing_microbenchmark.png", plot=gg, width=18, height=20, unit="cm", dpi=72)
