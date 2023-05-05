import request from '@/utils/request'

// 查询评论测试列表
export function listTestComment(query) {
  return request({
    url: '/test/testComment/list',
    method: 'get',
    params: query
  })
}

// 查询评论测试详细
export function getTestComment(id) {
  return request({
    url: '/test/testComment/' + id,
    method: 'get'
  })
}

// 新增评论测试
export function addTestComment(data) {
  return request({
    url: '/test/testComment',
    method: 'post',
    data: data
  })
}

// 修改评论测试
export function updateTestComment(data) {
  return request({
    url: '/test/testComment',
    method: 'put',
    data: data
  })
}

// 删除评论测试
export function delTestComment(id) {
  return request({
    url: '/test/testComment/' + id,
    method: 'delete'
  })
}
