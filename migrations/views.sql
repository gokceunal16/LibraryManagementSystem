CREATE VIEW rooms_view AS
SELECT r.id                 as room_id,
       r.name               as room_name,
       ts.start_time        as start_time,
       ts.end_time          as end_time,
       (res.id IS NOT NULL) as is_reserved
FROM rooms r
         CROSS JOIN time_slots ts
         LEFT JOIN reservations res ON r.id = res.room_id;


CREATE VIEW reviews_view AS
SELECT r.id                          as review_id,
       r.comment                     as comment,
       u.id                          as user_id,
       u.first_name                  as user_first_name,
       u.last_name                   as user_last_name,
       r.created_at                  as review_creation_time,
       (r.created_at = r.updated_at) as is_review_edited
FROM reviews r
         INNER JOIN users u on r.user_id = u.id;


CREATE VIEW scores_view AS
SELECT publication_id,
       AVG(score) as score
FROM ratings
GROUP BY publication_id;


CREATE VIEW book_details_view AS
SELECT pb.id                                                   as physical_book_id,
       pb.book_origin_id                                       as book_origin_id,
       pb.page_number                                          as page_number,
       pp.id                                                   as physcial_publication_id,
       pp.floor_number                                         as floor_number,
       pp.section_number                                       as section_number,
       pp.shelf_number                                         as shelf_number,
       p.id                                                    as publication_id,
       p.title                                                 as title,
       g.name                                                  as genre,
       l.name                                                  as language,
       p.translator                                            as translator,
       p.description                                           as description,
       s.score                                                 as score,
       a.first_name                                            as author_first_name,
       a.last_name                                             as author_last_name,
       p.image_name                                            as image_name,
       (b.publication_id IS NULL OR b.return_date IS NOT NULL) as is_available
FROM physical_books pb
         INNER JOIN physical_publications pp ON pb.physical_publication_id = pp.id
         INNER JOIN publications p ON pp.publication_id = p.id
         INNER JOIN book_origins bo on pb.book_origin_id = bo.id
         INNER JOIN genres g ON p.genre_id = g.id
         INNER JOIN languages l ON p.language_id = l.id
         INNER JOIN authors a ON bo.author_id = a.id
         LEFT JOIN scores_view s ON p.id = s.publication_id
         LEFT JOIN borrowings b ON p.id = b.publication_id;


CREATE VIEW notification_requests_view AS
SELECT u.id    as user_id,
       u.email as user_email,
       p.id    as publication_id,
       p.title as publication_title
FROM users u
         INNER JOIN publication_available_notification_requests panr on u.id = panr.user_id
         INNER JOIN publications p on panr.publication_id = p.id;


