module Example where


getList = find 5 where
     find 0 = return []
     find n = do
       ch <- getChar
       if ch `elem` ['a'..'e'] then do
             tl <- find (n-1)
             return (ch : tl) else
           find n
