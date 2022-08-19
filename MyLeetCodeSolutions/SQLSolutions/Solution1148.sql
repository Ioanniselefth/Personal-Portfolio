#1148. Article Views I
SELECT DISTINCT author_id AS id FROM Views 
where author_id = viewer_id 
GROUP BY id
ORDER BY author_id;