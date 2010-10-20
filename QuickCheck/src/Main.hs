module Main where

import Test.QuickCheck

main::IO()
main = undefined

prop_RevUnit x = reverse [x] == [x]

prop_RevApp xs ys = reverse (ys++xs) == reverse ys ++ reverse xs

prop_RevRev xs = reverse (reverse xs) == xs
