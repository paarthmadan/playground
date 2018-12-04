class Edge

  attr_reader :from, :to, :cost

  def initialize(from, to, cost)
    @from = from
    @to = to
    @cost = cost
  end

  def to_s
    "#{@from} ---> #{@to}, with #{@cost} weight."
  end

end
