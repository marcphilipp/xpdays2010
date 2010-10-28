import Test.QuickCheck
import List

qsort :: Ord a => [a] -> [a]
qsort []     = []
qsort (x:xs) = qsort kleiner ++ [x] ++ qsort groesser
                   where
                      kleiner  = [y | y <- xs, y < x]
                      groesser = [y | y <- xs, y >= x]

ordered :: (Ord a) => [a] -> Bool
ordered [] = True
ordered [x] = True
ordered (x1:x2:xs)
	   | x1 <= x2 = ordered (x2:xs)
	   | otherwise = False
	   
prop_QSortOrdered :: [Int] -> Bool
prop_QSortOrdered xs = ordered (qsort xs)


prop_QSortOrdered2 xs = ordered xs `trivial` ordered (qsort xs)
		   where types = xs::[Int]

prop_QSortOrdered3 xs = collect (length xs)$
		   ordered (qsort xs)
		   where types = xs::[Int]

prop_QSortOrdered4 xs = collect (length xs)$
		   ordered xs `trivial` ordered (qsort xs)
		   where types = xs::[Int]

prop_QSortSameLength xs = collect (length xs)$
		     (length xs) == (length (qsort xs))
		     where types = xs::[Int]

prop_QSortSameElements xs = collect (length xs)$
		     ordered xs `trivial` hasSameElements xs (qsort xs)
		     where types = xs::[Int]


hasSameElements [] ys = (length ys) == 0
hasSameElements (x:xs) ys = length xInLeftList == length xInRightList 
		       && hasSameElements leftListWOx rightListWOx
		       where
			(xInLeftList, leftListWOx) = partition (==x) (x:xs)
			(xInRightList, rightListWOx) = partition (==x) ys


prop_ListOrdered :: [Int] -> Bool
prop_ListOrdered xs = ordered xs

-- verboseCheck zeigt, dass ohne die Typdeklaration nur Mengen mit denselben Elementen erzeugt werden
