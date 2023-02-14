--
-- PostgreSQL database dump
--

-- Dumped from database version 13.4
-- Dumped by pg_dump version 13.4

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

ALTER TABLE IF EXISTS ONLY develop.sys_authority DROP CONSTRAINT IF EXISTS sys_authority_pk;
DROP TABLE IF EXISTS develop.sys_user_role_link;
DROP TABLE IF EXISTS develop.sys_user_authority_link;
DROP TABLE IF EXISTS develop.sys_user;
DROP TABLE IF EXISTS develop.sys_role;
DROP TABLE IF EXISTS develop.sys_menu;
DROP TABLE IF EXISTS develop.sys_authority;
DROP SCHEMA IF EXISTS develop;
--
-- Name: develop; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA develop;


ALTER SCHEMA develop OWNER TO postgres;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: sys_authority; Type: TABLE; Schema: develop; Owner: postgres
--

CREATE TABLE develop.sys_authority (
    id character varying(32) NOT NULL,
    authority_name character varying(20) NOT NULL,
    version_no smallint NOT NULL,
    create_time timestamp without time zone NOT NULL,
    create_by character varying(32) NOT NULL,
    update_time timestamp without time zone NOT NULL,
    update_by character varying(32) NOT NULL
);


ALTER TABLE develop.sys_authority OWNER TO postgres;

--
-- Name: sys_menu; Type: TABLE; Schema: develop; Owner: postgres
--

CREATE TABLE develop.sys_menu (
    id character varying(32) NOT NULL,
    menu_name character varying(20) NOT NULL,
    order_no smallint,
    pid character varying(32),
    version_no smallint NOT NULL,
    create_time timestamp without time zone NOT NULL,
    create_by character varying(32) NOT NULL,
    update_time timestamp without time zone NOT NULL,
    update_by character varying(32) NOT NULL
);


ALTER TABLE develop.sys_menu OWNER TO postgres;

--
-- Name: sys_role; Type: TABLE; Schema: develop; Owner: postgres
--

CREATE TABLE develop.sys_role (
    id character varying(32) NOT NULL,
    role_name character varying(20) NOT NULL,
    version_no smallint NOT NULL,
    create_time timestamp without time zone NOT NULL,
    create_by character varying(32) NOT NULL,
    update_time timestamp without time zone NOT NULL,
    update_by character varying(32) NOT NULL
);


ALTER TABLE develop.sys_role OWNER TO postgres;

--
-- Name: sys_user; Type: TABLE; Schema: develop; Owner: postgres
--

CREATE TABLE develop.sys_user (
    id character varying(32) NOT NULL,
    user_name character varying(20) NOT NULL,
    user_password character varying(200) NOT NULL,
    version_no smallint NOT NULL,
    create_time timestamp without time zone NOT NULL,
    create_by character varying(32) NOT NULL,
    update_time timestamp without time zone NOT NULL,
    update_by character varying(32) NOT NULL
);


ALTER TABLE develop.sys_user OWNER TO postgres;

--
-- Name: sys_user_authority_link; Type: TABLE; Schema: develop; Owner: postgres
--

CREATE TABLE develop.sys_user_authority_link (
    id character varying(32) NOT NULL,
    user_id character varying(32) NOT NULL,
    authority_id character varying(32) NOT NULL,
    version_no smallint NOT NULL,
    create_time timestamp without time zone NOT NULL,
    create_by character varying(32) NOT NULL,
    update_time timestamp without time zone NOT NULL,
    update_by character varying(32) NOT NULL
);


ALTER TABLE develop.sys_user_authority_link OWNER TO postgres;

--
-- Name: sys_user_role_link; Type: TABLE; Schema: develop; Owner: postgres
--

CREATE TABLE develop.sys_user_role_link (
    id character varying(32) NOT NULL,
    user_id character varying(32) NOT NULL,
    role_id character varying(32) NOT NULL,
    version_no smallint NOT NULL,
    create_time timestamp without time zone NOT NULL,
    create_by character varying(32) NOT NULL,
    update_time timestamp without time zone NOT NULL,
    update_by character varying(32) NOT NULL
);


ALTER TABLE develop.sys_user_role_link OWNER TO postgres;

--
-- Data for Name: sys_authority; Type: TABLE DATA; Schema: develop; Owner: postgres
--

INSERT INTO develop.sys_authority (id, authority_name, version_no, create_time, create_by, update_time, update_by) VALUES ('1', 'demo:read', 1, '2022-04-20 11:58:04.869', 'SYSTEM', '2022-04-20 11:58:04.869', 'SYSTEM');


--
-- Data for Name: sys_menu; Type: TABLE DATA; Schema: develop; Owner: postgres
--

INSERT INTO develop.sys_menu (id, menu_name, order_no, pid, version_no, create_time, create_by, update_time, update_by) VALUES ('1', '软件工程', 1, NULL, 1, '2022-04-20 11:58:14.052', 'SYSTEM', '2022-04-20 11:58:14.052', 'SYSTEM');
INSERT INTO develop.sys_menu (id, menu_name, order_no, pid, version_no, create_time, create_by, update_time, update_by) VALUES ('2', '高中', 2, NULL, 1, '2022-04-20 11:58:14.052', 'SYSTEM', '2022-04-20 11:58:14.052', 'SYSTEM');
INSERT INTO develop.sys_menu (id, menu_name, order_no, pid, version_no, create_time, create_by, update_time, update_by) VALUES ('6', 'hah', 1, '10', 1, '2022-04-20 11:58:14.052', 'SYSTEM', '2022-04-20 11:58:14.052', 'SYSTEM');
INSERT INTO develop.sys_menu (id, menu_name, order_no, pid, version_no, create_time, create_by, update_time, update_by) VALUES ('d92f30406bea459d8421e41546ed13df', 'java', 0, '1', 1, '2023-02-14 11:37:26.678741', 'System', '2023-02-14 11:37:26.678741', 'System');
INSERT INTO develop.sys_menu (id, menu_name, order_no, pid, version_no, create_time, create_by, update_time, update_by) VALUES ('11f8b922db084929a322d25fdeba5e0f', 'java', 0, '1', 1, '2023-02-14 11:40:57.231903', 'System', '2023-02-14 11:40:57.231903', 'System');


--
-- Data for Name: sys_role; Type: TABLE DATA; Schema: develop; Owner: postgres
--

INSERT INTO develop.sys_role (id, role_name, version_no, create_time, create_by, update_time, update_by) VALUES ('1', 'ROLE_test', 1, '2022-04-20 11:58:20.654', 'SYSTEM', '2022-04-20 11:58:20.654', 'SYSTEM');
INSERT INTO develop.sys_role (id, role_name, version_no, create_time, create_by, update_time, update_by) VALUES ('2', 'ROLE_Admin', 1, '2022-04-20 11:58:20.654', 'SYSTEM', '2022-04-20 11:58:20.654', 'SYSTEM');


--
-- Data for Name: sys_user; Type: TABLE DATA; Schema: develop; Owner: postgres
--

INSERT INTO develop.sys_user (id, user_name, user_password, version_no, create_time, create_by, update_time, update_by) VALUES ('1', 'albert', '$2a$10$v1R4ufaet6nJwUBaFM0I4OTCXUXCtvPrdpSfyMn5dOJ8LPWgKWPqK', 1, '2022-04-20 11:58:27.528', 'SYSTEM', '2022-04-20 11:58:27.528', 'SYSTEM');


--
-- Data for Name: sys_user_authority_link; Type: TABLE DATA; Schema: develop; Owner: postgres
--

INSERT INTO develop.sys_user_authority_link (id, user_id, authority_id, version_no, create_time, create_by, update_time, update_by) VALUES ('1', '1', '1', 1, '2022-04-20 11:58:37.486', 'SYSTEM', '2022-04-20 11:58:37.486', 'SYSTEM');


--
-- Data for Name: sys_user_role_link; Type: TABLE DATA; Schema: develop; Owner: postgres
--

INSERT INTO develop.sys_user_role_link (id, user_id, role_id, version_no, create_time, create_by, update_time, update_by) VALUES ('1', '1', '1', 1, '2022-04-20 11:58:45.511', 'SYSTEM', '2022-04-20 11:58:45.511', 'SYSTEM');


--
-- Name: sys_authority sys_authority_pk; Type: CONSTRAINT; Schema: develop; Owner: postgres
--

ALTER TABLE ONLY develop.sys_authority
    ADD CONSTRAINT sys_authority_pk PRIMARY KEY (id);


--
-- PostgreSQL database dump complete
--

