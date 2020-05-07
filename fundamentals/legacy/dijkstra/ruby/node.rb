class Node

  attr_reader :label, :edges

  def initialize(label)
    @label = label
    @edges = []
  end

  def add_edge(edge)
    @edges << edge unless edge.from != self
  end

  def to_s
    @label
  end

end
